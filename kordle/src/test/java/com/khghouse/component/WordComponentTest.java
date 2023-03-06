package com.khghouse.component;

import com.github.kimkevin.hangulparser.HangulParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class WordComponentTest {
    @InjectMocks
    private WordComponent wordComponent;

    @Test
    void separate_word() throws HangulParserException {
        // given
        String word = "한글";

        // when
        List<String> result = wordComponent.separateWord(word);

        // then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get(0)).isEqualTo("ㅎ");
        assertThat(result.get(2)).isEqualTo("ㄴ");
        assertThat(result.get(4)).isEqualTo("ㅡ");
    }

    @Test
    void separate_new_word() throws HangulParserException {
        // given
        String word = "진솔";

        // when
        List<String> result = wordComponent.separateWord(word);

        // then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get(0)).isEqualTo("ㅈ");
        assertThat(result.get(2)).isEqualTo("ㄴ");
        assertThat(result.get(4)).isEqualTo("ㅗ");
    }

    @Test
    void combine_word() throws HangulParserException {
        // given
        List<String> words = Arrays.asList("ㅎ", "ㅏ", "ㄴ", "ㄱ", "ㅡ", "ㄹ");

        // when
        String result = wordComponent.combineWord(words);

        // then
        assertThat(result).isEqualTo("한글");
    }
}
