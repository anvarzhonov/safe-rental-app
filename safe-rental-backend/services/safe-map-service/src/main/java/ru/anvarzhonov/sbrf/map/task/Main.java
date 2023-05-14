package ru.anvarzhonov.sbrf.map.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    class DataCenter {

        private int countResets = 0;
        private int countServers;
        private List<Boolean> workingServers = new ArrayList<>(countServers);

        DataCenter(int countServers) {
            this.countServers = countServers;
        }

        public int getCountResets() {
            return countResets;
        }

        public int getCountServers() {
            return countServers;
        }

        public List<Boolean> getWorkingServers() {
            return workingServers;
        }

        public int getCountResetWithWorkingServers() {
            return countResets * getCountWorkingServers();
        }
        public int getCountWorkingServers() {
            return (int) workingServers.stream()
                    .filter( status -> status.equals(Boolean.TRUE))
                    .count();
        }
    }
    // номер дата-центра с cостоянием по каждому из серверов. Дефолтное значение - true.
    Map<Integer, DataCenter> dataCenterMap;
    enum Action {
        RESET,
        DISABLE,
        GETMAX,
        GETMIN;
    }

    public int getMax() {

        var max = new AtomicInteger();
        dataCenterMap.forEach((k, v) -> {
            if(v.getCountResets() == 0) {

            }
            int count = v.getCountResetWithWorkingServers();
            if (count > max.get()) {
               max.set(count);
           }

        });
        return 0;
    }
    public static void main(String[] args) {

    }
}
