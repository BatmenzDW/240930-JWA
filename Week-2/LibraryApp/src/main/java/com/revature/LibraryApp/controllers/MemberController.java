package com.revature.LibraryApp.controllers;

import com.revature.LibraryApp.models.Member;
import com.revature.LibraryApp.services.MemberService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void registerPaths(Javalin app){
        app.get("/members", this::getAllMembers); // Supplies the JAvalin Context object to the associated method
        //app.get("/members", ctx -> getAllMembers(ctx));
        app.post("/members", this::createMember);
        app.put("/members/{id}", this::updateMember); // path variable
        app.delete("/members/{id}", this::deleteMember);
    }

    private void deleteMember(Context ctx) {
        int memberId = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = memberService.deleteMember(memberId);
        // Note: We don't include a body to save on bandwidth and time as we don't need any other information to be supplied when deleting
        if(deleted){
            ctx.result("Member deleted successfully");
            ctx.status(204);
        } else {
            ctx.result("No member found with that ID");
            ctx.status(404);
        }
    }

    private void updateMember(Context ctx) {
        // TODO: Catch NumberFormatException
        int memberId = Integer.parseInt(ctx.pathParam("id")); //exact match to the path variable provided as an argument
        Member member = ctx.bodyAsClass(Member.class);
        Member updatedMember = memberService.updateMember(memberId, member);
        if(updatedMember == null){
            ctx.result("No member found with that ID or the ID in the body does not match the ID in the path");
            ctx.status(404);
        } else {
            ctx.json(updatedMember);
            ctx.status(200);
        }
    }

    private void createMember(Context ctx) {
        Member member = ctx.bodyAsClass(Member.class); // Javalin Context using ObjectMapper to convert the JSON in our BODY to a Member object
        Member createdMember = memberService.createMember(member);
        ctx.status(201);
        ctx.json(createdMember);
    }

    public void getAllMembers(Context ctx) {
        List<Member> memberList = memberService.getAllMembers();
        if(memberList.isEmpty()){
            ctx.result("No members found");
            ctx.status(404);
        } else {
            ctx.json(memberList);
            ctx.status(200);
        }
    }
}
