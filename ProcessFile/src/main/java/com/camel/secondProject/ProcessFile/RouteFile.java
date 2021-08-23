package com.camel.secondProject.ProcessFile;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteFile extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		consumeFile();
		
	}

	private void consumeFile() {
	
		from("file:///D://CamelDocs//inp").process("FileContentTransformProcess")
		.to("file:///D://CamelDocs//output");
		
	}

}
