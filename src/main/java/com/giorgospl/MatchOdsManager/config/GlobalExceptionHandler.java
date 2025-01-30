//package com.giorgospl.MatchOdsManager.config;
//
//import com.giorgospl.MatchOdsManager.model.Result;
//import com.giorgospl.MatchOdsManager.model.enums.ErrorCode;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<Result> handleCustomException(CustomException ex) {
//        Result result = new Result(
//                ex.getErrorMessage(),
//                false,
//                1,
//                ex.getErrorCode()
//        );
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<Result> handleCHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
//        Result result = new Result(
//                ErrorCode.CODE_1.getDescription(),
//                false,
//                1,
//                ErrorCode.CODE_1.getCode()
//        );
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Result> handleGlobalException() {
//        Result result = new Result(
//                ErrorCode.CODE_2.getDescription(),
//                false,
//                1,
//                ErrorCode.CODE_2.getCode()
//        );
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//}
