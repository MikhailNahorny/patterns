package com.nahorny.pattern.behavioral.state;

public class Human implements Activity{
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void changeActivity(){
        if(activity instanceof Sleep){
            setActivity(new Learn());
        } else if(activity instanceof Learn){
            setActivity(new Work());
        } else if(activity instanceof Work){
            setActivity(new Sport());
        } else if(activity instanceof Sport){
            setActivity(new Sleep());
        }
    }

    @Override
    public void justDoIt() {
        activity.justDoIt();
    }
}
