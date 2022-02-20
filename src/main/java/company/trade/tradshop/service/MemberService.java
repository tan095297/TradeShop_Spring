package company.trade.tradshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.trade.tradshop.model.Member;
import company.trade.tradshop.repository.MemberRepository;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    


    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public List<Member> findMemberByName(String name){
        return memberRepository.findByNameContaining(name);
    }

    public Optional<Member> findMemberById(String id){
        return memberRepository.findById(id);
    }

    public Optional<Member> updateMember(String id, Member member){
        // import old product from ID prodcut
        Member currentMember = memberRepository.findById(id).get();
        currentMember.setName(member.getName());
        currentMember.setTel(member.getTel());
        currentMember.setSex(member.getSex());
        currentMember.setBirthday(member.getBirthday());
        currentMember.setAddress(member.getAddress());
        currentMember.setEmail(member.getEmail());
        currentMember.setLineId(member.getLineId());
        
        return Optional.of(memberRepository.save(currentMember));
    }

    public boolean deleteMember(String id){
        try {
            memberRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
