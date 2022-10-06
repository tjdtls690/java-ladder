package ladder.step2.domain;

import ladder.step2.dto.PlayerNameDTO;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Players {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\s?[a-zA-Z]{1,5})*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    private final List<PlayerName> players;
    
    public Players(String playerNames) {
        this.players = parsePlayers(playerNames);
    }
    
    private List<PlayerName> parsePlayers(String playerNames) {
        checkAllPlayerNamesInputExceptionCase(playerNames);
        return convertToPlayers(deleteSpace(playerNames));
    }
    
    private String deleteSpace(String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
    
    private List<PlayerName> convertToPlayers(String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }
    
    private void checkAllPlayerNamesInputExceptionCase(String playerNames) {
        checkNull(playerNames);
        checkPlayerNamesInputForm(playerNames);
    }
    
    private void checkNull(String playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private void checkPlayerNamesInputForm(String playerNames) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public int size() {
        return players.size();
    }
    
    public List<PlayerNameDTO> playerNamesInformation() {
        return players.stream()
                .map(PlayerName::playerNameInformation)
                .collect(Collectors.toList());
    }
}