package ru.trushkin.spring.example2.app.mbean;

public class ProfilingController implements ProfilingControllerMXBean {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
