package company.trade.tradshop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.trade.tradshop.model.Member;
// import company.trade.tradshop.repository.MemberRepository;
import company.trade.tradshop.service.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping("")
    public ResponseEntity<Object> addMember(@RequestBody Member member){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Member Success!");
        map.put("data", memberService.addMember(member));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };
    
    @GetMapping("")
    public ResponseEntity<Object> getAllMember(){
        List<Member> members = memberService.getMembers();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", members);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMemberById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", memberService.findMemberById(id));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getMemberByName(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", memberService.findMemberByName(name));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };


    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMember(@PathVariable String id, @RequestBody Member member){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Member Success!");
        map.put("data", memberService.updateMember(id, member));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    // @PatchMapping("/{id}")
    // public ResponseEntity<Object> addRevies(@PathVariable String id, @RequestBody Review review){
    //     HashMap<String, Object> map = new HashMap<>();
    //     map.put("msg", "Add Review Success!");
    //     map.put("data", productService.addReview(id, review));
    //     return new ResponseEntity<Object>(map,HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if(!memberService.deleteMember(id)){
            map.put("msg", "Error delete");
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            map.put("msg", "Delete success");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }
}
