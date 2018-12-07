package com.example.java_designpattern.mediator;

import javax.print.attribute.standard.Media;

/**
 * Created by wuxiaojun on 2018/12/7.
 */

public abstract class Colleague {

	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

}
