package com.khghouse.component;

import com.github.kimkevin.hangulparser.HangulParser;
import com.github.kimkevin.hangulparser.HangulParserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class WordComponent {
    public List<String> separateWord(String word) throws HangulParserException {
        return HangulParser.disassemble(word);
    }

    public String combineWord(List<String> words) throws HangulParserException {
        return HangulParser.assemble(words);
    }
}
