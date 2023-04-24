package com.portfolioRueda.portfolio.Security.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class msg {
    private String message;

    public msg() {}
    public msg(String message) {
        this.message = message;
    }
}
