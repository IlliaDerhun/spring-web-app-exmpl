# spring-web-app-exmpl

<h3>In master branch</h3>
  Simple example of Spring MVC and Hibernate work together.
  In master branch it is configured by XML file: spring-web-app-exmpl.xml
  
<h3>In aop branch</h3>
  The same project but logged with AspectJ through <mark>AOP</mark>
  
<h3>In javaConfig branch</h3>
  The same project as in "aop" and "master" branches
  But gonfigured not by XML file but vonfigured by JavaConfig and Annotations
  
<h4>How to set up this application</h4>
First of all clone the repo
  <h5>Set up My SQL DB</h5>
    <ol>
      <li>In resources folder you will find 02-customer-tracker.sql file;</li>
          (The SQL script to install data in DB)
      <li>Just copy this sctipt in your My SQL environment and run;</li>
      <li>If you have some specific location to your DB change it into SetUpConfiguration.java in myDataSource() method</li>
      <li>Done.</li>
    </ol>
    
And finally run it locally on your localServer (Tomca, JBoss etc...)
Other stuff the Spring framework will do instead you automagically
