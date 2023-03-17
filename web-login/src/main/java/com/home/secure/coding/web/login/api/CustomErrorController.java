package com.home.secure.coding.web.login.api;

import com.home.secure.coding.web.login.api.model.WebLoginRequestModel;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {

    public String error(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("loginRequestModel", WebLoginRequestModel.builder().build());
        Object requestUri = httpServletRequest.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        if (requestUri == null) {
            requestUri = "login";
        }
        Object statusCode = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = httpServletRequest.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (statusCode != null && exception != null) {
            model.addAttribute("error", statusCode.toString() + " - " + getRootCause(exception));
            return requestUri.toString();
        } else {
            AuthenticationException authenticationException = getLastAuthException(httpServletRequest);
            if (authenticationException != null) {
                model.addAttribute("error", HttpServletResponse.SC_UNAUTHORIZED + " - " + authenticationException.getMessage());
                return requestUri.toString();
            }
        }
        setErrorAttribute(model, statusCode);
        return "error";
    }

    private void setErrorAttribute(Model model, Object statusCode) {
        if (statusCode != null) {
            model.addAttribute("error", statusCode.toString());
        } else {
            model.addAttribute("error", HttpServletResponse.SC_UNAUTHORIZED + " - " + "Authorization error!");
        }
    }

    private AuthenticationException getLastAuthException(HttpServletRequest httpServletRequest) {
        Object authenticationException = httpServletRequest.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (authenticationException == null) {
            authenticationException = httpServletRequest.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        }
        return authenticationException != null ? (AuthenticationException) authenticationException : null;
    }

    private String getRootCause(Object exception) {
        Throwable throwable = (Throwable) exception;
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable.getMessage();
    }
}
