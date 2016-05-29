# grails-prometheus
Sample code for configuring prometheus jmx exporter agent to be used with a Grails 3 application

The JMX exporter jar is included directly in the project lib directory and referenced in the build.gradle script.

The agent is included on the embedded Tomcat startup command by a custom bootRun task in build.gradle 

Dropwizard JVM metrics to be exposed to Prometheus are configured in grails-app/init/Bootstrap.groovy

