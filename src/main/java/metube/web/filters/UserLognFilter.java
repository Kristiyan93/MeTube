package metube.web.filters;

import metube.domein.models.binding.UserLoginBindingModel;
import metube.domein.models.binding.UserRegisterBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class UserLognFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getMethod().toLowerCase().equals("post")) {
            UserLoginBindingModel userLoginBindingModel = new UserLoginBindingModel();

            userLoginBindingModel.setUsername(req.getParameter("username"));
            userLoginBindingModel.setPassword(req.getParameter("password"));

            req.setAttribute("logging", userLoginBindingModel);
        }

        filterChain.doFilter(req, resp);
    }
}
