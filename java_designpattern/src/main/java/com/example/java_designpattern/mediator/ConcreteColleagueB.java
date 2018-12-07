package com.example.java_designpattern.mediator;

/**
 * Created by wuxiaojun on 2018/12/7.
 */

public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}

	public void someOperation() {
		// 在需要跟其他同事通信的时候，通知中介者对象
		getMediator().change(this);
	}

}
