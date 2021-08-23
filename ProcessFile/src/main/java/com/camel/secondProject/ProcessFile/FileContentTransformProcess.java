package com.camel.secondProject.ProcessFile;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("FileContentTransformProcess")
public class FileContentTransformProcess implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
	
		Message inputMessage =exchange.getIn();
		String s = inputMessage.getBody(String.class);
		StringTokenizer str = new StringTokenizer(s, ",");
		
		String id = str.nextToken();
		String name = str.nextToken();
		
		
		// output message
		String dataModified = "{ID: "+id+",NAME: "+name+"}";
		
		//read output message reference
		Message output = exchange.getMessage();
		
		//Set data to output
		output.setBody(dataModified);
		
	}

}
