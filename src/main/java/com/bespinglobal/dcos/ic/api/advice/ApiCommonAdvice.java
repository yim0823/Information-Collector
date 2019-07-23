package com.bespinglobal.dcos.ic.api.advice;

import com.bespinglobal.dcos.ic.api.exception.NotFoundException;
import com.bespinglobal.dcos.ic.api.response.ApiException;
import com.bespinglobal.dcos.ic.api.response.ApiResponseCode;
import com.bespinglobal.dcos.ic.api.response.ApiResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * Project : Information-Collector
 * Class : ApiCommonAdvice
 * Version : 2019.07.16 v0.1
 * Created by taehyoung.yim on 2019-07-16.
 * *** 저작권 주의 ***
 */
@Order(value = 1)
@RestControllerAdvice // REST 요청에 대한 에러를 핸들링
public class ApiCommonAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ApiCommonAdvice.class);

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public ApiResponseDto<String> handleBaseException(ApiException e) {
        return ApiResponseDto.createException(e);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponseDto<String> handleBaseException(ConstraintViolationException e) {
        return ApiResponseDto.createException(ApiResponseCode.BAD_PARAMETER, "파라미터가 잘못됐습니다.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotFoundException.class})
    public ApiResponseDto<String> handleValidException(NotFoundException e) {
        ApiResponseDto<String> exception = ApiResponseDto.createException(new ApiException(ApiResponseCode.NOT_FOUND, e.getMessage()));
        logger.error("[{}] {}", ApiResponseCode.NOT_FOUND.getId(), exception);
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConversionFailedException.class})
    public ApiResponseDto<String> handleValidException(ConversionFailedException e) {
        String errorMessage = String.format(" %s 요청 파라미터를 확인해주세요.", e.getTargetType().getType().getSimpleName());
        ApiResponseDto<String> exception = ApiResponseDto.createException(new ApiException(ApiResponseCode.BAD_PARAMETER, errorMessage));
        logger.error("[{}] {}", ApiResponseCode.BAD_PARAMETER.getId(), exception);
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponseDto<String> handleValidException(MethodArgumentNotValidException e) {

        BindingResult result = e.getBindingResult();

        String errorMessage = String.format(" %s 요청 파라미터를 확인해주세요.", Objects.requireNonNull(result.getFieldError()).getField());
        ApiResponseDto<String> exception = ApiResponseDto.createException(new ApiException(ApiResponseCode.BAD_PARAMETER, errorMessage));
        logger.error("[{}] {}", ApiResponseCode.BAD_PARAMETER.getId(), exception);
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public ApiResponseDto<ErrorMessageCollection> handleValidException(BindException e) {

        ApiResponseDto<ErrorMessageCollection> exception = ApiResponseDto.createException(
                ApiResponseCode.BAD_PARAMETER,
                new ErrorMessageCollection(e.getBindingResult().getFieldErrors(), e.getBindingResult().getGlobalErrors()));

        logger.error("[{}] {}", ApiResponseCode.BAD_PARAMETER.getId(), exception);
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public ApiResponseDto<String> handleValidException(NumberFormatException e) {
        return ApiResponseDto.createException(ApiResponseCode.BAD_PARAMETER, "파라미터가 잘못됐습니다.");
    }
}
