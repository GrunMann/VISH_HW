package edu.blog.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class AbstractServlet extends HttpServlet {

    private HttpServletRequest request;
    
    private HttpServletResponse response;
    
    private HttpSession session;
    
    private static final Pattern REQUEST_PATTERN;
    
    static {
        REQUEST_PATTERN = Pattern.compile("^/([^/]+)(/([^/]+){0,1}(/.*){0,1}){0,1}$");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        super.service(request, response);
    }
    
    protected final HttpServletRequest getRequest() {
        return request;
    }
    
    protected final HttpServletResponse getResponse() {
        return response;
    }
    
    protected final HttpSession getSession() {
        return session;
    }
    
    protected final String getRequsetString() {
        String context = request.getContextPath();
        String uri = request.getRequestURI();
        return uri.replace(context, "");
    }
    
    private String getAction() {
        Matcher matcher = REQUEST_PATTERN.matcher(getRequsetString());
        if (matcher.matches()) {
            try {
                String action = matcher.group(3);
                if (action != null) {
                    return action;
                }
            } catch(IndexOutOfBoundsException e) {}
            return "index";
        }
        throw new IllegalArgumentException("Request does not match the pattern!");
    }
    
    private String toCamelCase(String source) {
        source = source.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (String part: source.split("-")) {
            char c = part.charAt(0);
            if (builder.length() > 0) {
                c = Character.toUpperCase(c);
            }
            builder.append(c).append(part.substring(1));
        }
        return builder.toString();
    }
    
    private void process() throws ReflectiveOperationException {
        RequestWrapper wrapper = new RequestWrapper(request);
        String action = getAction();
        action = toCamelCase(action);
        Class cls = getClass();
        Method method = cls.getMethod(action, wrapper.getTypes());
        method.invoke(this, wrapper.getParameters());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            super.doGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            super.doPost(request, response);
        }
    }

    protected final void forward(String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/" + path + ".jsp");
        dispatcher.forward(request, response);
    }
    
    protected final void redirect(String location) throws IOException {
        if (location.matches("^/")) {
            location = request.getContextPath() + location;
            
        }
        response.setHeader("Location", location);
        response.setStatus(302);
        response.getWriter().close();
    }
    
}
