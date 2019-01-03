package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	@Autowired
	private TestRepository testRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot Test!\n" + 
	           "number?thisNumber=11000\n" + 
			   "number1?thisNumber=11000\n"  +
	           "number2?thisNumber=11000\n"+
	           "number3?thisNumber=11000\n";
	}

	@RequestMapping("/test")
	public @ResponseBody Iterable<TestRecord> test() {
		int i = 100000;
		log.info(this.electNumber3(i).toString());
		log.info(this.electNumber2(i).toString());
		log.info(this.electNumber1(i).toString());
		log.info(this.electNumber(i).toString());

		i = 1000000;
		log.info(this.electNumber3(i).toString());
		log.info(this.electNumber2(i).toString());
		log.info(this.electNumber1(i).toString());
		log.info(this.electNumber(i).toString());
		i = 10000000;
		log.info(this.electNumber3(i).toString());
		// log.info(this.electNumber2(i).toString());
		// log.info(this.electNumber1(i).toString());
		// log.info(this.electNumber(i).toString());
		i = 100000000;
		// log.info(this.electNumber3(i).toString());
		// log.info(this.electNumber2(i).toString());
		// log.info(this.electNumber1(i).toString());
		// log.info(this.electNumber(i).toString());
		return testRepository.findAll();
	}

	@RequestMapping("/number")
	public TestRecord electNumber(@RequestParam int thisNumber) {
		Long timeStart = System.currentTimeMillis();
		List<Integer> list = new ArrayList<Integer>(), removeList = new ArrayList<Integer>();

		for (int i = 1; i <= thisNumber; i++) {
			list.add(i);
		}

		int a = 0, b = 0;
		while (true) {
			if (list.size() > 1) {
				b++;
				log.info("————————————————第{}轮开始：list.size={}，a={}", b, list.size(), a);
				log.debug(list.toString());
				for (int i = 0; i < list.size(); i++) {
					a++;
					if (a % 2 == 1) {
						removeList.add(list.get(i));
					}
				}
				list.removeAll(removeList);
				log.info("第{}轮结束！结果如下：", b);
				log.debug(list.toString());
				removeList.clear();
				;
				log.info("a={}", a);
			} else {
				break;
			}
		}
		Long timeEnd = System.currentTimeMillis();
		TestRecord t = new TestRecord();
		t.setNumber(thisNumber);
		t.setCounts(a);
		t.setRounds(b);
		t.setRusult_number(list.get(0));
		t.setTimes(timeEnd - timeStart);
		t.setFuncName("electNumber");
		testRepository.save(t);
		return t;
	}

	@RequestMapping("/number1")
	public TestRecord electNumber1(@RequestParam int thisNumber) {
		Long timeStart = System.currentTimeMillis();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= thisNumber; i++) {
			list.add(i);
		}

		int a = 0, b = 0;
		while (true) {
			if (list.size() > 1) {
				b++;
				log.info("————————————————第{}轮开始：list.size={}，a={}", b, list.size(), a);
				log.debug(list.toString());
				for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
					a++;
					iterator.next();
					if (a % 2 == 1) {
						iterator.remove();
					}
				}
				log.info("第{}轮结束！结果如下：", b);
				log.debug(list.toString());
				log.info("a={}", a);
			} else {
				break;
			}
		}
		Long timeEnd = System.currentTimeMillis();
		TestRecord t = new TestRecord();
		t.setNumber(thisNumber);
		t.setCounts(a);
		t.setRounds(b);
		t.setRusult_number(list.get(0));
		t.setTimes(timeEnd - timeStart);
		t.setFuncName("electNumber1");
		testRepository.save(t);
		return t;
	}

	@RequestMapping("/number2")
	public TestRecord electNumber2(@RequestParam int thisNumber) {
		Long timeStart = System.currentTimeMillis();
		List<Integer> list = new LinkedList<Integer>();

		log.info("start:{}", thisNumber);
		for (int i = 1; i <= thisNumber; i++) {
			list.add(i);
		}
		log.info("初始化完成");

		int a = 0, b = 0;
		while (true) {
			if (list.size() > 1) {
				b++;
				log.info("————————————————第{}轮开始：list.size={}，a={}", b, list.size(), a);
				log.debug(list.toString());
				for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
					a++;
					iterator.next();
					if (a % 2 == 1) {
						iterator.remove();
					}
				}
				log.info("第{}轮结束！结果如下：", b);
				log.debug(list.toString());
				log.info("a={}", a);
			} else {
				break;
			}
		}
		Long timeEnd = System.currentTimeMillis();
		TestRecord t = new TestRecord();
		t.setNumber(thisNumber);
		t.setCounts(a);
		t.setRounds(b);
		t.setRusult_number(list.get(0));
		t.setTimes(timeEnd - timeStart);
		t.setFuncName("electNumber2");
		testRepository.save(t);
		return t;
	}

	@RequestMapping("/number3")
	public TestRecord electNumber3(@RequestParam int thisNumber) {
		Long timeStart = System.currentTimeMillis();
		List<Integer> list = new ArrayList<Integer>(), removeList = new ArrayList<Integer>();

		for (int i = 1; i <= thisNumber; i++) {
			list.add(i);
		}

		int a = 0, b = 0;
		while (true) {
			if (list.size() > 1) {
				b++;
				log.info("————————————————第{}轮开始：list.size={}，a={}", b, list.size(), a);
				// log.info(list.toString());
				for (int i = 0; i < list.size(); i++) {
					a++;
					if (a % 2 == 0) {
						removeList.add(list.get(i));
					}
				}
				list.clear();
				list.addAll(removeList);
				log.info("第{}轮结束！结果如下：", b);
				// log.info(list.toString());
				removeList.clear();
				;
				log.info("a={}", a);
			} else {
				break;
			}
		}
		Long timeEnd = System.currentTimeMillis();
		TestRecord t = new TestRecord();
		t.setNumber(thisNumber);
		t.setCounts(a);
		t.setRounds(b);
		t.setRusult_number(list.get(0));
		t.setTimes(timeEnd - timeStart);
		t.setFuncName("electNumber3");
		testRepository.save(t);
		return t;
	}
}
