
package com.starzplay.payment.utill;


public class BadRequestException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int code;

    public BadRequestException() {
    }

    public BadRequestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
