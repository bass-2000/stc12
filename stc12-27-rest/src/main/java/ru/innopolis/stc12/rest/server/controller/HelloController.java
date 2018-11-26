package ru.innopolis.stc12.rest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc12.rest.server.dto.Message;
import ru.innopolis.stc12.rest.server.dto.Request;
import ru.innopolis.stc12.rest.server.dto.Response;
import ru.innopolis.stc12.rest.server.service.CheckInSl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@RestController
public class HelloController {
    private CheckInSl checkInSl;

    @Autowired
    public void setCheckInSl(CheckInSl checkInSl) {
        this.checkInSl = checkInSl;
    }

    @RequestMapping("/rest")
    public Request hello() {
        //return "I'm a rest controller";
        return checkInSl.getRequest();
    }

    @RequestMapping("/rest/{userName}")
    public Message message(@PathVariable String userName) {
        Message msg = new Message(userName, "Hello, " + userName);
        return msg;
    }

    @RequestMapping(value = "/checkInSl", method = RequestMethod.GET)
    public Response checkInSl(@RequestBody String request) {
        Request objRequest = getRequestFromString(request);
        return checkInSl.checkInSl(objRequest);
    }

    private Request getRequestFromString(String request) {
        Request objRequest = null;
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Request.class);
            StringReader reader = new StringReader(request);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            objRequest = (Request) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return objRequest;
    }


}