package com.greedie.pay.greediebackoffice.controller;

import com.greedie.pay.greediebackoffice.data.entity.MemberMoneyJpaEntity;
import com.greedie.pay.greediebackoffice.data.entity.MembershipJpaEntity;
import com.greedie.pay.greediebackoffice.data.repository.MemberMoneyRepository;
import com.greedie.pay.greediebackoffice.data.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TemplateController {
    private final MembershipRepository membershipRepository;
    private final MemberMoneyRepository memberMoneyRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/member")
    public String member(Model model) {
        List<MembershipJpaEntity> all = membershipRepository.findAll();
        model.addAttribute("members", all);
        return "member";
    }

    @GetMapping("/money")
    public String money(Model model) {
        List<MemberMoneyJpaEntity> all = memberMoneyRepository.findAll();
        model.addAttribute("moneys", all);
        return "money";
    }
}
