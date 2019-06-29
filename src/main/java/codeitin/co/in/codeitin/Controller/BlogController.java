package codeitin.co.in.codeitin.Controller;



import codeitin.co.in.codeitin.DAO.About;
import codeitin.co.in.codeitin.DAO.Spring;
import codeitin.co.in.codeitin.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    BlogService blogService;

    List<String> files = new ArrayList<String>();

    //post spring content
    @RequestMapping(method = RequestMethod.POST, value ="/content" )
    public ResponseEntity<String> handleTestUpload(@RequestParam("file") MultipartFile file){
        String message = "";
        try {
            blogService.base(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            System.out.print("FAILED.....");
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @RequestMapping(method = RequestMethod.POST ,value = "/add")
    public void add(@RequestBody Spring spring) throws IOException {
        blogService.addfile(spring);
    }

//post about content
    @RequestMapping(method = RequestMethod.GET,value = "/about")
    public void filedump() throws IOException {
        blogService.fileread();
    }
//get about content
    @RequestMapping(method = RequestMethod.GET,value = "/aboutall")
    public List<About> getall(){
        return blogService.about();
    }

    //get spring content
    @RequestMapping(method= RequestMethod.GET, value = "/storage")
    public List<Spring> store(){
        return blogService.value();
    }
    //delete spring content
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{topic}")
    public void del(@PathVariable("topic") String topic){
        blogService.del(topic);
    }

}
