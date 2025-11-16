package knu.database.musebase.domain.manager.controller;

import knu.database.musebase.console.PageController;
import knu.database.musebase.domain.manager.auth.ManagerSessionWrapper;
import knu.database.musebase.domain.manager.console.ManagerPageKey;
import knu.database.musebase.exception.InvalidLoginStateException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SongRequestManageController implements PageController<ManagerPageKey> {
    private final ManagerSessionWrapper sessionWrapper;

    @Override
    public void displayScreen() throws InvalidLoginStateException {
        if (!sessionWrapper.validateLogin()) {
            System.out.println("로그인 실패");
            throw new InvalidLoginStateException();

        }

        System.out.println("\n--- 악곡 요청 관리 페이지 (관리자) ---");
        System.out.println("관리자 ID: " + sessionWrapper.getManagerSession().getLoggedInNickname());
        // (데이터베이스 연동 시) 실제 데이터 조회
        System.out.println("내가 담당중인 요청 수: 5 (예시)");
        System.out.println("담당자가 없는 요청 개수: 2 (예시)");
        System.out.println("--------------------------------");
        System.out.println("1. 요청 수락");
        System.out.println("2. 요청 완료(삭제)");
        System.out.println("0. 돌아가기");
    }

    @Override
    public ManagerPageKey invoke(String[] commands) {
        switch (commands[0]) {
            case "1":
                return ManagerPageKey.MANAGER_MAIN;
            case "2":
                return
        }
        return ManagerPageKey.REQUEST_MANAGEMENT;
    }

    // 서비스 함수들을 따로 나눠주기
    public Song
}
