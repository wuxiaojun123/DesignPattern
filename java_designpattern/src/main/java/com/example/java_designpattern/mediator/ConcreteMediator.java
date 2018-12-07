package com.example.java_designpattern.mediator;

/**
 * Created by wuxiaojun on 2018/12/7.
 */

public class ConcreteMediator implements Mediator {

	private ConcreteColleagueA	concreteColleagueA;

	private ConcreteColleagueB	concreteColleagueB;

	public ConcreteMediator() {

	}

	@Override public void change(Colleague colleague) {
		// 某个同事类发生了变化，通常需要与其他同事交互
		// 具体协调相应的同事对象来实现写作行为
	}

	public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
		this.concreteColleagueA = concreteColleagueA;
	}

	public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
		this.concreteColleagueB = concreteColleagueB;
	}

}
