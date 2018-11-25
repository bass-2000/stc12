package ru.innopolis.stc12.springSp;

public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
