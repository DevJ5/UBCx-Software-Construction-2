package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }


    @Override
    public Iterator iterator() {
        return new PhraseIterator();
    }

    private class PhraseIterator implements Iterator<Phrase> {
        private Iterator<Phrase> phraseIterator = phrases.iterator();
        private int numWordsNeeded;

        public PhraseIterator() {
            calculateNumWordsNeeded();
        }

        private void calculateNumWordsNeeded() {
            while (phraseIterator.hasNext()) {
                Phrase phrase = phraseIterator.next();
                if (phrase.needsWord()) numWordsNeeded++;
            }
        }

        @Override
        public boolean hasNext() {
            return numWordsNeeded > 0;
        }

        @Override
        public Phrase next() {
            Iterator<Phrase> phraseIteratorLocal = phrases.iterator();
            Phrase nextPhrase = phraseIteratorLocal.next();
            while (!nextPhrase.needsWord()) {
                nextPhrase = phraseIteratorLocal.next();
            }
            numWordsNeeded--;
            return nextPhrase;
        }
    }
}
