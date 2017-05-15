# Hello World Example ConfigMap example

## Requirements

- You have running hello world exmaple (previous one)

## Modifications from base example

- HelloController modified to add properties from the ConfigMap

```
@RestController
public class HelloController {

	@Value("${property.one}")
	String one;

	@Value("${property.two}")
	String two;

	@RequestMapping("/")
	public String hello() {
		return one +" " +two;
	}

}
```

- Starter added to pom dependencies

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-kubernetes-config</artifactId>
			<version>${project.version}</version>
		</dependency>
```

- Created ConfigMap with referenced properties. Create it in your kubernetes/openshift cluster 
```
oc create -f  spring-cloud-kubernetes/spring-cloud-kubernetes-examples/kubernetes-hello-world-example-configmap/src/main/resources/hello-world-configmap.yml
```

- Run the application 

`mvn clean package fabric8:build fabric8:resource fabric8:apply fabric8:deploy`

- Query the endpoint

`curl kubernetes-hello-world-myproject.192.168.99.101.nip.io`

that returns `hola mundo`
