package com.example.applicant.dto;

import java.util.Collections;
import java.util.List;

/**
 * 클라이언트에게 전달할 응답메세지를 담당하는 클래스다.
 */
public class ResultDto {
    private String title;
    private String description;
    private String resultCode;
    private String errorMessage;
    private List<? extends Object> items;

    /**
     * 제목과 아이템을 포함하는 성공적인 응답메세지를 생성한다.<br/>
     * 설명은 제목과 동일, 응답코드는 "OK", 에러메세지는 비어있다.
     * @param title 제목
     * @param items 아이템, 사이즈가 0일 수 있다.
     */
    public ResultDto(String title, List<? extends Object> items) {
        this.title = title;
        this.description = title;
        this.resultCode = "OK";
        this.items = items;
    }

    /**
     * 제목과 설명, 아이템을 포함하는 성공적인 응답메세지를 생성한다.<br/>
     * 응답코느는 "OK" 에러메세지는 비어있다.
     * @param title 제목
     * @param description 설명
     * @param items 아이템, 사이즈가 0일 수 있다.
     */
    public ResultDto(String title, String description, List<? extends Object> items) {
        this.title = title;
        this.description = description;
        this.resultCode = "OK";
        this.items = items;
    }
    
    /**
     * 제목과 응답코드를 포함하는 응답메세지를 생성한다.<br/>
     * 설명은 제목과 동일, 에러메세지는 비어있고, 아이템도 비어있다.
     * @param title 제목
     * @param resultCode 응답코드
     */
    public ResultDto(String title, String resultCode) {
        this.title = title;
        this.description = title;
        this.resultCode = resultCode;;
        this.items = Collections.emptyList();
    }
    
    /**
     * 제목, 응답코드, 에러메세지를 포함하는 응답메세지를 생성한다.<br/>
     * 에러발생시 사용되는 응답메세지를 생성한다.<br/>
     * 설명을 제목과 동일하고, 아이템을 비어있다.
     * @param title 제목
     * @param resultCode 에러코드
     * @param errorMessage 에러메세지
     */
    public ResultDto(String title, String resultCode, String errorMessage) {
        this.title = title;
        this.description = title;
        this.resultCode = resultCode;
        this.errorMessage = errorMessage;
        this.items = Collections.emptyList();
    }

    /** 
     * 제목, 설명, 응답코드, 에레메세지를 포함하는 응답메세지를 생성한다.<br/>
     * 에러발생시 사용되는 응답 메세지를 생성한다.<br/>
     * 아이템을 비어있다.
     * @param title 제목
     * @param description 설명
     * @param resultCode 에러코드
     * @param errorMessage 에러메세지
    */
    public ResultDto(String title, String description, String resultCode, String errorMessage) {
        this.title = title;
        this.description = title;
        this.resultCode = resultCode;
        this.errorMessage = errorMessage;
        this.items = Collections.emptyList();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<? extends Object> getItems() {
        return items;
    }

    public int getSize() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
}