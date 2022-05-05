###Notes 
the student class just represents a student. what student will
do, how student will be enrolled, etc. it doesn't care. 

We are building a 3 tier application. 
1. presentation layer(using html)
2. business logic layer(Java)
3. Data base (SQL)

dao(database access object): this object is allowed to access
databases. We want spring to manage it. 

If we are scanning the base package to the application context, 
we have to add Configuration marker to the classes. Otherwise,
Spring will not consider the classes to be configured. 

While we add the @Component marker to a class, Spring will consider
it as a bean, and it will construct a bean for us. But, this method
is good only if our class has a simple logic of building bean. 

But, if we have a lot of configuration, we have to go with the 
@Configuration method. 

We can add the @Autowired to automatically set the values 
to a bean. It is a setter based injection. 

***Benefit of Constructor based injection***

When we are using the constructor based injection, our application
will fail during start-up. Because, bean will not be created. 
But, if we are using a setter based injection,  we may have 
a null pointer exception. If the bean is not there, it will
not be autowired. So, if there is a null pointer exception during 
run-time, our application can crash. 


Spring Boot

It is a framework within spring. It is an opinionated framework. 
It will act upon what we supply. Spring boot takes our
opinion, and it does the configuration automatically. If we 
are developing a spring application, and we want to connect to 
database, we have to configure everything.
In this project, we added database, jdbc. Now, spring will 
go and create a jdbc bean for us. It looks at what we've 
added in the pom file. 

Every database requires a database connection string. 

in the application.yml file, 
spring is the key
datasource is the value. 
Springboot will grab the information in the yml, create a 
datasource connection for us and give us a database connection. 

we can create a database for our application by creating 
a data.sql file. 
After creating the database in sql, we have to specify the
console  in the yml file. 

the website localhost:9000/h2 is coming from the spring application.
This is not the ultimate edition. 

@Repository is an alias for component. We usually use this
annotation to represent database classes. Now in Student DAO, 
we write a method to create a student. we will be using a 
jdbc template for that. jdbc template is the class from 
spring jdbc framework. 

In the StudentDAO, we create a method to create a Student.
when we execute a query in database, It will tell us how many
rows are impacted. 
After we created a StudentDAO named dao and passed a 
student to the createStudent(), we got a null pointer exception.
It is showing the jdbc template is null. It was because in
StudentDAO, we marked a No args constructor. 

jdbc template is a low level class written by spring to deal 
with the databases. It uses our data source to connect to 
the database. 

jdbc template is used to execute query in database. 

Sequence: sequence is a database object. we need sequence to
maintain unique ID's. 

in the STUDENTDAO class, it is important to remember the question 
marks properly. 

We can create our own Row Mapper class. 
The rs.getdate() returns a date and not an instant. So, 
we converted it into an instant. 
We can even use a lambda expression instead of this one because 
the RowMapper is a functional interface. 

the template.queryForObject() should be used instead of template.query because 
template.query is for a list of objects and it will return a List.
queryForObject() will work for a single object. 

if the port is already in use, we can either change the port 
or kill the process that is using it. 

When we run the code, it gave us an error. Because, the date
doesnt have a time style. 

Instead of JDBC template, we can use named parameter jdbc template. 
But, while creating the Student, the Bean names should match
with the names that are passed into the sql statement. 
Otherwise we need to create our own implementation or we need to create a map. 


When you're dealing with a low level database operation,
you want to have a full control, jdbc template is the best
fit. 


##MVC- Model View Controller
model is the data.
view is our presentation layer. 
Controller's role is to facilitate data for a view.  
Controller controls the view and it stitches data with a view. 

Servlet is a program which actually runs on the server. 

what happens when we access a web application:
we make an http get call. It is made to a DNS server(Domain
name server). This request will be forwarded to an IP address
and this IP address will belong to a machine(server).
A Server serves a request. Servers are always listening. 
They are always up and running. 

In java, every view is served by servlets. Servlets are the
programs which runs our server. The servers that we have
in our Java world are **Tomcat**, **Websphere**, **Weblogic**,
**Jetty**, etc.

Spring comes with Dispatcher servlets. Spring uses this
dispatcher servlets, and it will configure them itself.
We just need to configure the path. The dispatcher 
servlet will get the request. We need to write 
the Controller layer. All the calls will be handled by 
dispatcher servlet. We annotate a class with a 
Controller layer. Spring will go and create a handler 
mapping. 
See the Dispatcher servlet image in google. 
if we go to localhost8080, by default when there is no 
view setted, we will get a whitelabel error page. 

we can keep our view in the directory called templates. 


