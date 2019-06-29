package codeitin.co.in.codeitin.Service;

import codeitin.co.in.codeitin.DAO.About;

import codeitin.co.in.codeitin.DAO.Spring;
import codeitin.co.in.codeitin.Repository.AboutRepository;
import codeitin.co.in.codeitin.Repository.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@ServletComponentScan
@Service
@EnableMongoAuditing
public class BlogService {
    @Autowired
    AboutRepository aboutRepository;

    @Autowired
    SpringRepository springRepository;

    private final Path baseLocation = Paths.get("upload-base");
    public void base(MultipartFile file) throws IOException {

        Files.copy(file.getInputStream(), this.baseLocation.resolve(file.getOriginalFilename()));
        String contents = new String(Files.readAllBytes(Paths.get("upload-base/"+file.getOriginalFilename())));
        String filename = file.getOriginalFilename();
        String title = filename.split("\\.")[0];
        Spring spring = new Spring();
        spring.setTopic(title);
        spring.setStore(contents);
        springRepository.save(spring);



    }

//play like a playboy

    public void addfile(Spring spring)throws IOException{
        System.out.print(spring.getTopic());
        System.out.print(spring.getStore());
        String added = new String(Files.readAllBytes(Paths.get(spring.getStore())));
        spring.setTopic(spring.getTopic());
        spring.setStore(added);
        springRepository.save(spring);
    }

    public void fileread() throws IOException {
        About about= new About();
        String mdfile = new String(Files.readAllBytes(Paths.get("C:\\Users\\SAURAV ROY\\Desktop\\mark.md")));
    about.setId("About The Blog");
        about.setContent(mdfile);
        aboutRepository.save(about);


    }

    public List<About> about(){
       return aboutRepository.findAll();
    }




    public List<Spring> value(){return springRepository.findAll();}


        public void init() throws IOException {

        Files.createDirectories(baseLocation);
    }

    public void delete() {
        FileSystemUtils.deleteRecursively(baseLocation.toFile());

    }



    public void del(String topic){
        springRepository.deleteById(topic);
    }
}


