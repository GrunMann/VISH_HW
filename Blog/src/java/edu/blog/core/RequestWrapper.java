package edu.blog.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {

    private final HttpServletRequest request;
    
    private final Object[] parameters;
    
    private final Class[] types;

    public RequestWrapper(HttpServletRequest request) {
        this.request = request;
        parameters = getParametersValues();
        types = getParametersTypes(parameters);
    }
    
    private Object getParameter(Object[] values) {
        if (values.length == 0) return null;
        else return values[0];
    }
    
    private Object[] getParametersValues() {
        Collection<String[]> values = request.getParameterMap().values();
        List<Object> buffer = new ArrayList<>();
        for (String[] value : values) buffer.add(getParameter(value));
        return buffer.toArray(new Object[buffer.size()]);
    }
    
    private Class[] getParametersTypes(Object[] params) {
        Class[] array = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            array[i] = params[i].getClass();
        }
        return array;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Class[] getTypes() {
        return types;
    }
    
}
