package homework2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import homework2.Tests.BST_Tests;
import homework2.Tests.Graph_Tests;
import homework2.Tests.NumIslands_Test;
import homework2.Tests.OrganizationStructure_Tests;
import homework2.Tests.Phonebook_Tests;
import homework2.Tests.Search_Tests;
import homework2.Tests.Tree_Tests;

@RunWith(Suite.class)
@SuiteClasses({ BST_Tests.class, Graph_Tests.class, NumIslands_Test.class, OrganizationStructure_Tests.class,
		Phonebook_Tests.class, Search_Tests.class, Tree_Tests.class })

public class Homework2_AllTests {
}
