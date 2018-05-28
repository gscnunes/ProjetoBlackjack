package jogoblackjacka;

import jogoblackjack.model.*;
import jogoblackjack.util.*;
import jogoblackjack.controller.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LinkedListTest.class,
	StackTest.class,
	BaralhoTest.class,
	CartaTest.class,
	CroupierTest.class,
        JogadorTest.class,
        MaoDeCartaTest.class,
        ControllerTest.class,
        ControllerArquivoTest.class,
        ControllerMenuTest.class,
})
public class AllTests { }

