package SimpleFeatures;

import org.apache.jena.rdf.model.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeaturesTest {

    private Resource[] r;

    @Before
    public void prepare() {
        int n = 100;
        r = new Resource[n];
        for (int i = 0; i < n; ++i) {
            r[i] = mock(Resource.class);
            when(r[i].toString()).thenReturn("http://example.com/foo#" + Integer.toString(i));
        }
    }


    @Test
    public void functionalTest() {
        MockSPARQLquery rows = new MockSPARQLquery(
                // 5 sprzyjajacych
                r[0], r[10],
                r[1], r[11],
                r[2], r[12],
                r[3], r[13],
                r[4], r[14],
                // 4 niesprzyjajace
                r[5], r[15],
                r[5], r[25],
                r[6], r[16],
                r[6], r[26],
                r[7], r[17],
                r[7], r[27]
        );
        TableOfPairs sortedByO = new TableOfPairs(new TableOfPairs(rows));
        TableOfPairs sortedByS = new TableOfPairs(sortedByO);
        Features f = new Features(sortedByS, sortedByO, 0.5);
        assertTrue(f.isFunctional());
        f = new Features(sortedByS, sortedByO, 0.9);
        assertFalse(f.isFunctional());
    }

    @Test
    public void inverseFunctionalTest() {
        MockSPARQLquery rows = new MockSPARQLquery(
                // 5 sprzyjajacych
                r[0], r[10],
                r[1], r[11],
                r[2], r[12],
                r[3], r[13],
                r[4], r[14],
                // 4 niesprzyjajace
                r[5], r[15],
                r[25], r[15],
                r[6], r[16],
                r[26], r[16],
                r[7], r[17],
                r[17], r[17]
        );
        TableOfPairs sortedByO = new TableOfPairs(new TableOfPairs(rows));
        TableOfPairs sortedByS = new TableOfPairs(sortedByO);
        Features f = new Features(sortedByS, sortedByO, 0.5);
        assertTrue(f.isInverseFunctional());
        f = new Features(sortedByS, sortedByO, 0.9);
        assertFalse(f.isInverseFunctional());
    }

    @Test
    public void reflexiveTest() {
        MockSPARQLquery rows = new MockSPARQLquery(
                // 5 sprzyjajacych
                r[0], r[0],
                r[0], r[10],
                r[1], r[1],
                r[1], r[11],
                r[2], r[2],
                r[2], r[12],
                r[3], r[3],
                r[3], r[13],
                r[4], r[4],
                r[4], r[14],
                // 4 niesprzyjajace
                r[5], r[15],
                r[5], r[25],
                r[6], r[16],
                r[6], r[26],
                r[7], r[17],
                r[7], r[27]
        );
        TableOfPairs sortedByO = new TableOfPairs(new TableOfPairs(rows));
        TableOfPairs sortedByS = new TableOfPairs(sortedByO);
        Features f = new Features(sortedByS, sortedByO, 0.5);
        assertTrue(f.isReflexive());
        f = new Features(sortedByS, sortedByO, 0.9);
        assertFalse(f.isReflexive());
    }

}
