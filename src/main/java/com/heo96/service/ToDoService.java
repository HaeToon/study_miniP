package com.heo96.service;


import com.heo96.dto.ToDoDto;

import java.util.*;

public class ToDoService {
    private Scanner sc = sc=new Scanner(System.in);
    private int processNum;
    private ToDoDto toDoDto;
    private List<String>userList;
    private List<String>questionList;
    private List<String>status;
    private Map<String,ToDoDto> responseMap;
    private List<Integer>ischecked;
    public ToDoService() {
        questionList = new ArrayList<>();
        status = new ArrayList<>();
        toDoDto = new ToDoDto();
        ischecked = new ArrayList<>();
        responseMap = new HashMap<>();
        questionList.add("1. 주간 보고서 작성");
        questionList.add("2. 이메일 확인 및 응답");
        questionList.add("3. 회의 준비");
        questionList.add("4. 프로젝트 계획서 수정");
        questionList.add("5.팀 멤버와의 1:1 면담");
        status.add("완료");
        status.add("진행중");
        processNum=1;
    }
    private void process1(){
        System.out.println("Input Your Name : ");
        String userName = sc.nextLine();
        userList = new ArrayList<>();
        userList.add(userName);
        processNum++;
    }
    private void process2(){
        System.out.println("1~5중 하나를 선택해 주세요");
        System.out.println("1. 주간 보고서 작성, 2. 이메일 확인 및 응답, 3. 회의 준비, 4. 프로젝트 계획서 수정, 5.팀 멤버와의 1:1 면담");
        int question = sc.nextInt();
        for(int i=0; i<ischecked.size(); i++){
            if(ischecked.get(i)==question){
                System.out.println(question+"번은 이미 답변한 사항입니다.");
                System.out.println("1~5중 하나를 선택해 주세요");
                System.out.println("1. 주간 보고서 작성, 2. 이메일 확인 및 응답, 3. 회의 준비, 4. 프로젝트 계획서 수정, 5.팀 멤버와의 1:1 면담");
                question = sc.nextInt();
            }
        }
        ischecked.add(question);
        toDoDto.setQuestion(questionList.get(question-1));
        System.out.println("상태를 입력해 주세요. 1. 완료 2. 진행중");
        int stat = sc.nextInt();
        toDoDto.setQuestion(status.get(stat-1));
        responseMap.put(userList.get(userList.size()-1),toDoDto);
        processNum++;
    }
    private void process3(){
        System.out.println("종료여부 c : 계속입력 , q : 다음사람 , x : 종료");
        String question = sc.next();
        if (question.equals("c")){
            processNum=2;
        }else if(question.equals("q")){
            processNum=1;
        } else if (question.equals("x")) {
            processNum=4;
            finish();
        }
    }
    private void finish(){
        for(int i=0; i<responseMap.size(); i++){
        System.out.println(userList.get(i)+responseMap.get(userList.get(i)).getQuestion()+responseMap.get(userList.get(i)).getStatus());
        }
    }



    public void run(){
        while(true){
            if(processNum==1){
                process1();
            }
            if(processNum==2){
                process2();
            }
            if(processNum==3){
                process3();
            }
            if(processNum==4){
                finish();
                break;
            }
        }
    }
}
