package ru.innopolis.stc12.rest.server.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc12.rest.server.dto.Request;
import ru.innopolis.stc12.rest.server.dto.Response;
import ru.innopolis.stc12.rest.server.dto.StopListItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Service
public class CheckInSl {
    public Response checkInSl(Request request) {
        if ("Иванов Иван Иванович".equals(request.getFio().trim())) {
            List<StopListItem> stopListItems = new ArrayList<>();
            stopListItems.add(new StopListItem("4.07", Calendar.getInstance(), Calendar.getInstance()));
            return new Response(stopListItems, "1");
        }
        return new Response(Collections.emptyList(), "3");
    }

    public Request getRequest() {
        return new Request("www", Calendar.getInstance(), "111");
    }
}
