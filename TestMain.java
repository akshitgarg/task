import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.TreeMap;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Test;


public class TestMain {
	
	// Test case for empty dictionary
	@Test
	public void testFindMissingValues0() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		assertEquals(Main.findMissingValues(input).size(),0);
	}
	// test case{2019-01-01:100, 2019-01-04:115}
	// output{2019-01-01:100,2019-01-02:105,2019-01-03:110, 2019-01-04:115}
	@Test
	public void testFindMissingValues1() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2019-01-01", 100);
		input.put("2019-01-04", 115);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2019-01-01",100);
		expectedOutput.put("2019-01-02",105);
		expectedOutput.put("2019-01-03",110);
		expectedOutput.put("2019-01-04",115);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
	// test case{2019-01-01:100}
	// output{2019-01-01:100}
	@Test
	public void testFindMissingValues2() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2019-01-01", 100);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2019-01-01",100);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
	// test case{2019-01-31:100, 2019-02-01:102}
	// output{2019-01-31:100, 2019-02-01:101, 2019-02-01:102}
	@Test
	public void testFindMissingValues3() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2019-01-31", 100);
		input.put("2019-02-02", 102);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2019-01-31", 100);
		expectedOutput.put("2019-02-01", 101);
		expectedOutput.put("2019-02-02",102);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
	// test case{2019-01-29:100,2019-01-31:102,2019-02-02:100}
	// output{2019-01-29:100, 2019-01-30:101, 2019-01-31:102, 2019-02-01:101, 2019-02-02:100}
	@Test
	public void testFindMissingValues4() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2019-01-29", 100);
		input.put("2019-01-31", 102);
		input.put("2019-02-02", 100);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2019-01-29", 100);
		expectedOutput.put("2019-01-30", 101);
		expectedOutput.put("2019-01-31", 102);
		expectedOutput.put("2019-02-01", 101);
		expectedOutput.put("2019-02-02", 100);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
	// test case{2019-02-27:100, 2019-03-01:102}
	// output{2019-02-27:100, 2019-02-28:101, 2019-03-01:102}
	@Test
	public void testFindMissingValues5() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2019-02-27", 100);
		input.put("2019-03-01", 102);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2019-02-27", 100);
		expectedOutput.put("2019-02-28", 101);
		expectedOutput.put("2019-03-01", 102);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
	// test case{2020-02-27:99, 2020-03-01:102}
	// output{2020-02-27:99, 2020-02-28:100, 2020-02-29:101, 2020-03-01:102+}
	@Test
	public void testFindMissingValues6() throws ParseException {
		TreeMap<String, Integer> input = new TreeMap<String, Integer>();
		input.put("2020-02-27", 99);
		input.put("2020-03-01", 102);
		TreeMap<String, Integer> expectedOutput = new TreeMap<String, Integer>();
		expectedOutput.put("2020-02-27", 99);
		expectedOutput.put("2020-02-28", 100);
		expectedOutput.put("2020-02-29", 101);
		expectedOutput.put("2020-03-01", 102);
		assertThat(Main.findMissingValues(input),is(expectedOutput));
	}
}
