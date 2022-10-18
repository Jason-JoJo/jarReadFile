package com.example.readFile.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
class ReadfileController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * getResourceAsStream
     * IDE OK, jar OK
     */
    @GetMapping("/read")
    public @ResponseBody String read() {
        System.out.println("read ");
        StringBuilder sb = new StringBuilder("");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("static/file/1.txt");
        InputStreamReader isr = new InputStreamReader(is);

        try (BufferedReader br = new BufferedReader(isr))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
                sb.append("||");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "this.getClass().getClassLoader().getResourceAsStream OK >>> "+sb.toString();
    }

    /**
     * ClassPathResource
     * IDE OK, jar not work
     */
    @GetMapping("/read2")
    public @ResponseBody String read2() throws IOException {
        System.out.println("read2 ");
        StringBuilder sb = new StringBuilder("");
        ClassPathResource resource = new ClassPathResource("static/file/1.txt");
        File sourceFile = resource.getFile();
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        try (BufferedReader br = new BufferedReader(isr))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
                sb.append("||");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ClassPathResource OK >>> "+sb.toString();
    }
}
