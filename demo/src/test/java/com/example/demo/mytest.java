package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class mytest {
	private static final Logger log = LoggerFactory.getLogger(mytest.class);
	@Autowired
	MyController m;
	
	@Test
	public void test() throws Exception {
		/*
		 * for (int n = 10000; n <= 10000; n++) System.out.println("\n" + n + "," +
		 * electNumber(n));
		 */
		//System.out.println(MockMvcRequestBuilders.get("/number?thisNumber=200").accept(MediaType.APPLICATION_JSON));
				//.andExpect(status().isOk()).andExpect(content().string(equalTo("Greetings from Spring Boot!"))));
		//System.out.println(content().string());
		int i=100000;
		log.info(m.electNumber3(i).toString());
		log.info(m.electNumber2(i).toString());
		log.info(m.electNumber1(i).toString());
		log.info(m.electNumber(i).toString());
		
		i=1000000;
		log.info(m.electNumber3(i).toString());
		log.info(m.electNumber2(i).toString());
		log.info(m.electNumber1(i).toString());
		log.info(m.electNumber(i).toString());
		i=10000000;
		log.info(m.electNumber3(i).toString());
		log.info(m.electNumber2(i).toString());
		log.info(m.electNumber1(i).toString());
		log.info(m.electNumber(i).toString());
		i=100000000;
		log.info(m.electNumber3(i).toString());
		log.info(m.electNumber2(i).toString());
		log.info(m.electNumber1(i).toString());
		log.info(m.electNumber(i).toString());
		
		
	}

	public void test1() {
		int p = 1998;
		List<Integer> resultList = new ArrayList<Integer>();
		for (int j = 1; j <= p; j++) {
			resultList.removeAll(resultList);
			for (int i = 1; i < j; i++) {
				// System.out.printf("%d:p*i:%d,p+i:%d,(p*i)mod(p+i):%d;\n",i,p*i,(p+i),(p*i)%(p+i));
				if ((j * i) % (j + i) == 0) {
					// System.out.println();
					resultList.add(i);
				}
			}
			if (resultList.size() > 0) {
				System.out.printf("%d,%d", j, resultList.size());
				resultList.forEach(i -> System.out.print("," + i));
				System.out.println();
			}
		}
	}
}
