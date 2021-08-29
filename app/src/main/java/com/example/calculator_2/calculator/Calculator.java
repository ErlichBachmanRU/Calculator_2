package com.example.calculator_2.calculator;

import com.example.calculator_2.R;

public class Calculator {
    private int numbOne;
    private int numbTwo;

    private StringBuilder userInput = new StringBuilder();

    private int operationSelected;

    private State state;

    private enum State {
        oneNumb,
        operationSelected,
        twoNumb,
        resultFinal
    }

    public Calculator() {
        state = State.oneNumb;
    }

    public void numbClicked(int numbsId) {

        if (state == State.resultFinal) {
            state = State.oneNumb;
            userInput.setLength(1);
        }

        if (state == State.operationSelected) {
            state = State.twoNumb;
            userInput.setLength(0);
        }

        if (userInput.length() < 9) {
            switch (numbsId) {
                case R.id.key_0:
                    if (userInput.length() != 0) {
                        userInput.append("0");
                    }
                    break;
                case R.id.key_1:
                    userInput.append("1");
                    break;
                case R.id.key_2:
                    userInput.append("2");
                    break;
                case R.id.key_3:
                    userInput.append("3");
                    break;
                case R.id.key_4:
                    userInput.append("4");
                    break;
                case R.id.key_5:
                    userInput.append("5");
                    break;
                case R.id.key_6:
                    userInput.append("6");
                    break;
                case R.id.key_7:
                    userInput.append("7");
                    break;
                case R.id.key_8:
                    userInput.append("8");
                    break;
                case R.id.key_9:
                    userInput.append("9");
                    break;
            }
        }

    }

    public void operatorClicked(int actionId) {
        if (actionId == R.id.btn_result && state == State.twoNumb && userInput.length() > 0) {
            numbTwo = Integer.parseInt(userInput.toString());
            state = State.resultFinal;
            userInput.setLength(0);
            switch (operationSelected) {
                case R.id.key_plus:
                    userInput.append(numbOne + numbTwo);
                    break;
                case R.id.key_minus:
                    userInput.append(numbOne - numbTwo);
                    break;
                case R.id.multiply:
                    userInput.append(numbOne * numbTwo);
                    break;
                case R.id.division:
                    userInput.append(numbOne / numbTwo);
                    break;
                case R.id.percent:
                    userInput.append((numbOne / 100) * numbTwo);
                    break;
            }

        } else if (userInput.length() > 0 && state == State.oneNumb && actionId != R.id.btn_result) {
            numbOne = Integer.parseInt(userInput.toString());
            state = State.operationSelected;
            operationSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return userInput.toString();
            case operationSelected:
                return str.append(numbOne).append(' ')
                        .append(getOperationChar())
                        .toString();
            case twoNumb:
                return str.append(numbOne).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(userInput)
                        .toString();
            case resultFinal:
                return str.append(userInput).toString();
        }
    }

    private char getOperationChar() {
        switch (operationSelected) {
            case R.id.key_plus:
                return '+';
            case R.id.key_minus:
                return '-';
            case R.id.multiplication:
                return '*';
            case R.id.percent:
                return '%';
            case R.id.division:
            default:
                return '/';

        }
    }

    public void reset() {
        state = State.oneNumb;
        userInput.setLength(0);
    }
}
