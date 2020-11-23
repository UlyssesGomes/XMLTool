# XMLTool
This is a project with a XMLTool to save and load java objects of xml files.

### Requirements
	* Java 1.8
	* Maven
	* Inellij IDE

### How to use

This is a project with an abstraction of a class called XMLFileTool.java that converts Java objects into xml files, and it is also possible to retrieve an object saved in xml to a Java object. The class has 2 public methods <b> saveObject </b> and <b> loadObjectFromXmlFile </b> that saves a java object in an xml file and retrieves a java object from an xml file respectively. To use this class, simply create an instance by calling "new" and pass the parameters of each function. In the Main.java class, there is an example of using both functions, but for the correct operation, it is necessary to use annotations in the entities with <b> @XmlRootElement (name = "entity_name") </b> so that the methods perform as operations correctly. It is important to remember that the "entity_name" attribute must be unique for each entity.

