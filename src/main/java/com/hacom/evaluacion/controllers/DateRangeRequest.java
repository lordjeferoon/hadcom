package com.hacom.evaluacion.controllers;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

public class DateRangeRequest {
    @NotNull
    @PastOrPresent
    private Date from;

    @NotNull
    @PastOrPresent
    private Date to;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}