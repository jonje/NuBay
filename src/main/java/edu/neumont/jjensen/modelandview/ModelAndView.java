package edu.neumont.jjensen.modelandview;

/**
 * Created by jjensen on 5/7/14.
 */
public class ModelAndView {

    private Object model;
    private String view;

    public Object getModel() {
        return model;
    }

    public void setModel(Object obj) {
        this.model = obj;
    }

    public String getViewName() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

}
