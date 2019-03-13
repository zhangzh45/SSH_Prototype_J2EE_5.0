package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.service.SerService;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bean.SpecTaskRoleUser;
import com.bean.Specification;
import com.bean.Service;
import com.opensymphony.xwork2.ActionContext;
import com.service.SpecTaskRoleUserService;
import com.service.SpecificationService;

public class ParseYawlFile {
	
	private static SpecTaskRoleUserService strusr;
	private static SpecificationService specsr;
	private static SerService srs;
	
	
	public SpecTaskRoleUserService getStrusr() {
		return strusr;
	}


	public void setStrusr(SpecTaskRoleUserService strusr) {
		this.strusr = strusr;
	}


	public SpecificationService getSpecsr() {
		return specsr;
	}


	public void setSpecsr(SpecificationService specsr) {
		this.specsr = specsr;
	}

	public SerService getSrs() {
		return srs;
	}

	public void setSrs(SerService srs) {
		ParseYawlFile.srs = srs;
	}

	/**
     * getSpecRole
     * function:get the role through business file by parse the business.xml
     * @param businessfilepath
     */
	public void getSpecRoleOrUser(String loginUser, String loginPassword, String businessfilepath){
		//List<SpecTaskRoleUser> list = new ArrayList<SpecTaskRoleUser>();
		
    	SAXReader saxReader=new SAXReader();
    	try {
    		File file=new File(businessfilepath);//流程文件的路径
    		//System.out.println(file);
    		String filecontent = readfile(businessfilepath);
			Document doc=saxReader.read(file);
			Element root=doc.getRootElement();//获取根节点
			 System.out.println("Root: " + root.getName());
			//Element specificationSet=root.element("specificationSet");
			Iterator specifications=root.elementIterator("specification");//遍历specificationSet下面所有的Bspecification节点
			System.out.println("specificationSet: " + specifications.toString());
			while(specifications.hasNext()){
				Element specification=(Element)specifications.next();
				System.out.println("specification: " + specification.attributeCount() +";"+ specification.getText());
				String specuri = "";
				Iterator Attribute=specification.attributeIterator();
				while(Attribute.hasNext()){
					Attribute att=(Attribute)Attribute.next();
					specuri = att.getValue();
					break;
				}
				System.out.println("specuri: " + specuri);
			    
				Iterator metaDatas=specification.elementIterator("metaData");
				String specid = "", specversion = "", specdesc = "", specname = "";
				while(metaDatas.hasNext()){
					Element metaData=(Element)metaDatas.next();
					
					Iterator specnames=metaData.elementIterator("title");
					while(specnames.hasNext()){
						Element name = (Element)specnames.next();
						specname = name.getText();
						break;
					}
					System.out.println("specname: " + specname);
					
					Iterator identifiers=metaData.elementIterator("identifier");
					while(identifiers.hasNext()){
						Element identifier=(Element)identifiers.next();
						specid = identifier.getText();
						break;
					}
					System.out.println("specid: " + specid);
					Iterator versions=metaData.elementIterator("version");
					while(versions.hasNext()){
						Element version=(Element)versions.next();
						specversion = version.getText();
						break;
					}
					System.out.println("specversion: " + specversion);
					Iterator descriptions=metaData.elementIterator("description");
					while(descriptions.hasNext()){
						Element description=(Element)descriptions.next();
						specdesc = description.getText();
						break;
					}
					System.out.println("specdesc: " + specdesc);
				}
				
				//保存流程到数据库
				Specification spec= new Specification(specid, specname, specuri, specversion, specdesc, filecontent, businessfilepath);
				System.out.print(spec.toString()+";;;");
				System.out.print(specsr.toString());
				specsr.addSpec(spec);
				
				//解析流程中的任务分配用户/角色
				Iterator decompositions=specification.elementIterator("decomposition");
				while(decompositions.hasNext()){
					Element decomposition=(Element)decompositions.next();
					Iterator processControlElements=decomposition.elementIterator("processControlElements");
					while(processControlElements.hasNext()){
						Element processControlElement=(Element)processControlElements.next();
						Iterator tasks=processControlElement.elementIterator("task");
						System.out.println("tasks: " + tasks.hasNext());
						while(tasks.hasNext()){
							Element task=(Element)tasks.next();
							Iterator itAttribute=task.attributeIterator();
							String taskid = "";
							while(itAttribute.hasNext()){
								Attribute att=(Attribute) itAttribute.next();
								taskid = att.getValue();
								break;
							}
							System.out.println("taskid: " + taskid);
							String taskname = "";
							Iterator tasknames=task.elementIterator("name");
							while(tasknames.hasNext()){
								Element name = (Element) tasknames.next();
								taskname = name.getText();
								break;
							}
							System.out.println("taskname: " + taskname);
							Iterator resourcings = task.elementIterator("resourcing");
							System.out.println("resourcings.hasNext(): " + resourcings.hasNext());
							while(resourcings.hasNext()){
								Element resourcing=(Element)resourcings.next();
								Iterator offers=resourcing.elementIterator("offer");
								System.out.println("offers.hasNext(): " + offers.hasNext());
								while(offers.hasNext()){
									Element offer=(Element)offers.next();
									Iterator distributionSets=offer.elementIterator("distributionSet");
									System.out.println("distributionSets.hasNext(): " + distributionSets.hasNext());
									while(distributionSets.hasNext()){
										Element distributionSet=(Element)distributionSets.next();
										Iterator initialSets=distributionSet.elementIterator("initialSet");
										System.out.println("initialSets.hasNext(): " + initialSets.hasNext());
										while(initialSets.hasNext()){
											Element initialSet=(Element)initialSets.next();
											Iterator roles=initialSet.elementIterator("role");
											while(roles.hasNext()){
												Element role = (Element)roles.next();
												String roleid = role.getText();
												String rolename = specuri + "&" + taskname + "&" + getRoleName(loginUser, loginPassword, roleid);
												//roleid = rolename;
												System.out.print(specuri+":"+taskid+":"+taskname+":"+roleid+":"+businessfilepath+":\n");
												
												SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, roleid, rolename,null);
												strusr.addSpecTaskRoleUser(stru);
												//list.add(stru);
												//break;
											}
											Iterator users=initialSet.elementIterator("participant");
											while(users.hasNext()){
												Element user = (Element)users.next();
												String userid = user.getText();
												System.out.print(specuri+":"+taskid+":"+taskname+":"+userid+":"+businessfilepath+":\n");
												
												SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, null, null,userid);
												strusr.addSpecTaskRoleUser(stru);
												//list.add(stru);
												//break;
											}
											//break;
										}
										//break;
									}
									
								}
								Iterator secondaries=resourcing.elementIterator("secondary");
								while(secondaries.hasNext()){
									Element secondary=(Element)secondaries.next();
									Iterator roles=secondary.elementIterator("role");
									while(roles.hasNext()){
										Element role = (Element)roles.next();
										String roleid = role.getText();
										System.out.print(specuri+":"+taskid+":"+taskname+":"+roleid+":"+businessfilepath+":\n");
										String rolename = specuri + "&" + taskname + "&" + getRoleName(loginUser, loginPassword, roleid);
										SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, roleid,rolename,null);
										strusr.addSpecTaskRoleUser(stru);
										//list.add(stru);
										//break;
									}
									Iterator users=secondary.elementIterator("participant");
									while(users.hasNext()){
										Element user = (Element)users.next();
										String userid = user.getText();
										System.out.print(specuri+":"+taskid+":"+taskname+":"+userid+":"+businessfilepath+":\n");
										SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, null,null, userid);
										strusr.addSpecTaskRoleUser(stru);
										//list.add(stru);
										//break;
									}
								}
							}
						}
						
						//break;
					}
					//break;
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//return list;
	}

	
	 public  String readfile(String filepath)      
     {   
	 	String filecontent = "";  
	 	try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"));  
		 	String line = ""; 
			while ((line = br.readLine()) != null) {  
				filecontent += line;  
			}
			br.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  	return filecontent;
   } 
	 
	public String getRoleName(String loginUser, String loginPassword, String roleId){
		String roleName = "";
		
		GetRemoteService grs = new GetRemoteService();
		String roles = grs.getAllRole(loginUser, loginPassword);
		System.out.println("roles:"+roles);
		try {
			if(roles != null && roles.length() > 1){
				roles = roles.substring(1, roles.length() - 1);
				roles = roles.replaceAll("\\\\", "");
				if(roles != null){
					JSONArray arr = new JSONArray(roles);
					if(arr.length() > 0){
						for(int i = 0; i < arr.length(); i++){
							JSONObject obj = new JSONObject();
							obj = (JSONObject) arr.get(i);
							if(obj.has(roleId)){
								System.out.println("rolename:"+(String) obj.get(roleId));
								return (String) obj.get(roleId);
							}

						}
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleName;
	}


	/**
	 * 获取流程所调用的服务及其调用次数
	 * @param businessfilepath
	 */
	public Map<Service, Integer> analyseCombinedBusiness(String businessfilepath){
		Map<Service, Integer> invokedServices = new HashMap<Service, Integer>();  //保存调用的服务及其次数
		SAXReader saxReader=new SAXReader();
		try {
			File file=new File(businessfilepath);//流程文件的路径
			//System.out.println(file);
			String filecontent = readfile(businessfilepath);
			Document doc=saxReader.read(file);
			Element root=doc.getRootElement();//获取根节点
			System.out.println("Root: " + root.getName());
			//Element specificationSet=root.element("specificationSet");
			Iterator specifications=root.elementIterator("specification");//遍历specificationSet下面所有的Bspecification节点
			System.out.println("specificationSet: " + specifications.toString());

			Map<String, String> WSDLVariable = new HashMap<String, String>();  //保存WSDLVariable的name及其value
			List<String> decompositionIds = new ArrayList<String>(); //保存yawlWSInvoker类型的decompositionID（即taskID）
			while(specifications.hasNext()) {
				Element specification = (Element) specifications.next();
				System.out.println("specification: " + specification.attributeCount() + ";" + specification.getText());
				Iterator decompositions = specification.elementIterator("decomposition");
				while (decompositions.hasNext()) {
					Element decomposition = (Element) decompositions.next();
					//获取流程的local variables
					Iterator localVariables = decomposition.elementIterator("localVariable");
					while (localVariables.hasNext()) {
						Element localVariable = (Element) localVariables.next();
						Iterator initialValues = localVariable.elementIterator("initialValue");
						if (initialValues.hasNext()) {
							Element initialValue = (Element) initialValues.next();
							if (initialValue.getText() != null && (initialValue.getText().contains("?WSDL") || initialValue.getText().contains("?wsdl"))) {
								String WSDLLocation = initialValue.getText();
								System.out.println("WSDLLocation: " + WSDLLocation);
								Service s = srs.findyByWSDLLocation(WSDLLocation).get(0);
								if (invokedServices.containsKey(s) == false) {  //添加调用的服务
									invokedServices.put(s, 0);
								}
								Iterator names = localVariable.elementIterator("name");
								if(names.hasNext()){
									Element name = (Element) names.next();
									WSDLVariable.put(name.getText(),WSDLLocation);
								}
							}
						}
					}

					Iterator yawlServices = decomposition.elementIterator("yawlService");
					while (yawlServices.hasNext()) {
						Element yawlService = (Element) yawlServices.next();
						Iterator yawlServiceAttribute = yawlService.attributeIterator();
						if(yawlServiceAttribute.hasNext()) {
							Attribute yawlServiceId = (Attribute) yawlServiceAttribute.next();
							String id = yawlServiceId.getValue();
							System.out.println("id: " + id);
							if(id.equalsIgnoreCase("http://localhost:8080/yawlWSInvoker")) {
								Iterator itAttribute = decomposition.attributeIterator();
								Attribute decompositionIdAtt = (Attribute)itAttribute.next();
								String decompositionId = decompositionIdAtt.getValue();
								System.out.println("indecompositionId: " + decompositionId);
								decompositionIds.add(decompositionId);
							}
						}
						break;
					}
					System.out.println("decompositionIds: " + decompositionIds.size());
				}

				decompositions = specification.elementIterator("decomposition");
				while (decompositions.hasNext()) {
					//查找相应task中的调用服务及其次数
					Element decomposition = (Element) decompositions.next();
					Iterator processControlElements=decomposition.elementIterator("processControlElements");
					while(processControlElements.hasNext()){
						Element processControlElement=(Element)processControlElements.next();
						Iterator tasks=processControlElement.elementIterator("task");
						System.out.println("tasks: " + tasks.hasNext());
						while(tasks.hasNext()){
							Element task=(Element)tasks.next();
							Iterator decomposesTos = task.elementIterator("decomposesTo");
							if(decomposesTos.hasNext()){
								Element decomposesTo = (Element)decomposesTos.next();
								Iterator itAttribute=decomposesTo.attributeIterator();
								while(itAttribute.hasNext()){
									Attribute decomposesToAtt =(Attribute) itAttribute.next();
									String decomposesToId = decomposesToAtt.getValue();
									System.out.println("decomposesToId: " + decomposesToId);
									if(decompositionIds.contains(decomposesToId)){   //证明是yawlWSInvoker类型的任务
										System.out.println("startingMappings: ");
										Iterator startingMappings = task.elementIterator("startingMappings");
										if(startingMappings.hasNext()){
											Element startingMapping = (Element)startingMappings.next();
											Iterator mappings = startingMapping.elementIterator("mapping");
											System.out.println("mapping: ");
											while(mappings.hasNext()){
												Element mapping = (Element)mappings.next();
												Iterator mapsTos = mapping.elementIterator("mapsTo");
												System.out.println("mapsTo");
												if(mapsTos.hasNext()){
													Element mapsTo = (Element)mapsTos.next();
													if(mapsTo.getText().equalsIgnoreCase("YawlWSInvokerWSDLLocation")){
														Iterator expressions = mapping.elementIterator("expression");
														if(expressions.hasNext()){
															Element expression = (Element)expressions.next();
															Iterator expressionAttribute=expression.attributeIterator();
															while(expressionAttribute.hasNext()) {
																Attribute expressionAtt = (Attribute) expressionAttribute.next();
																String expressionQuery = expressionAtt.getValue();
																System.out.println("expressionQuery: " + expressionQuery);
																Set<String> keys = WSDLVariable.keySet();
																Iterator keysIterator = keys.iterator();
																while(keysIterator.hasNext()){
																	String key = (String)keysIterator.next();
																	System.out.println("key: " + key);
																	if(expressionQuery.contains(key)){
																		String WSDLLocation = WSDLVariable.get(key);
																		Service s = srs.findyByWSDLLocation(WSDLLocation).get(0);
																		if (invokedServices.containsKey(s) == false) {  //添加调用的服务
																			invokedServices.put(s, 1);
																		}
																		else{
																			invokedServices.put(s, invokedServices.get(s) + 1);
																		}
																		break;
																	}
																}
															}
														}

													}

												}
											}
										}
									}
									break;
								}
							}
						}
						break;
					}
				}
				break;
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("invokedServices: " + invokedServices.toString());
		return invokedServices;
	}
}

