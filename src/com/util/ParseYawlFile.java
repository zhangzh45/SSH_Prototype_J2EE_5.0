package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bean.SpecTaskRoleUser;
import com.bean.Specification;
import com.service.SpecTaskRoleUserService;
import com.service.SpecificationService;

public class ParseYawlFile {
	
	private static SpecTaskRoleUserService strusr;
	private static SpecificationService specsr;
	
	
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


	/**
     * getSpecRole
     * function:get the role through business file by parse the business.xml
     * @param the business file path
     */
	public void getSpecRoleOrUser(String businessfilepath){
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
				Specification spec= new Specification(specid, specname, specuri, specversion, specdesc, filecontent, businessfilepath);
				System.out.print(spec.toString()+";;;");
				System.out.print(specsr.toString());
				specsr.addSpec(spec);
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
												System.out.print(specuri+":"+taskid+":"+taskname+":"+roleid+":"+businessfilepath+":\n");
												
												SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, roleid, null);
												strusr.addSpecTaskRoleUser(stru);
												//list.add(stru);
												//break;
											}
											Iterator users=initialSet.elementIterator("participant");
											while(users.hasNext()){
												Element user = (Element)users.next();
												String userid = user.getText();
												System.out.print(specuri+":"+taskid+":"+taskname+":"+userid+":"+businessfilepath+":\n");
												
												SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, null, userid);
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
										SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, roleid, null);
										strusr.addSpecTaskRoleUser(stru);
										//list.add(stru);
										//break;
									}
									Iterator users=secondary.elementIterator("participant");
									while(users.hasNext()){
										Element user = (Element)users.next();
										String userid = user.getText();
										System.out.print(specuri+":"+taskid+":"+taskname+":"+userid+":"+businessfilepath+":\n");
										SpecTaskRoleUser stru = new SpecTaskRoleUser(specid, taskid, taskname, null, userid);
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
}

