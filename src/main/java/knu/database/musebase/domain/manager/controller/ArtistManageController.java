package knu.database.musebase.domain.manager.controller;

import knu.database.musebase.dao.ArtistDAO;
import knu.database.musebase.domain.manager.console.ManagerPageKey;
import knu.database.musebase.domain.manager.auth.ManagerAuthService;
import knu.database.musebase.domain.manager.auth.ManagerSession;
import knu.database.musebase.console.PageController;
import knu.database.musebase.domain.manager.auth.ManagerSessionWrapper;
import knu.database.musebase.exception.InvalidLoginStateException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArtistManageController implements PageController<ManagerPageKey> {
    private final ManagerAuthService authService;
    private final ManagerSessionWrapper managerSessionWrapper;
    private final ArtistDAO artistDAO;

    @Override
    public void displayScreen() throws InvalidLoginStateException {

        if (!managerSessionWrapper.validateLogin()) {
            throw new InvalidLoginStateException();
        }

        System.out.println("\n--- 아티스트 관리 ---");
        System.out.println("관리자 ID: " + managerSessionWrapper.getManagerSession().getLoggedInNickname());
        System.out.println("1. 아티스트 정보 확인 [아티스트 ID]");
        System.out.println("2. 아티스트 추가 [추가할 정보]");
        System.out.println("3. 아티스트 수정 [아티스트 ID] [변화할 인자] [값]");
        System.out.println("4. 아티스트 삭제 [아티스트 ID]");
        System.out.println("0. 돌아가기");
    }

    @Override
    public ManagerPageKey invoke(String[] commands) {
        switch (commands[0]) {
            case "1":

            case "2":

            case "3":

            case "4":

            case "0":
                return ManagerPageKey.MANAGER_MAIN;
        }
    }
}
