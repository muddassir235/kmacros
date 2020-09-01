package com.muddassir.kmacros

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.io.Serializable
import kotlin.Exception

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestPersistence {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testSaveLoadBool() {
        context.save("test_bool", true)
        assertTrue(context.load("test_bool", Boolean::class)?:false)
    }

    @Test
    fun testSaveLoadInt() {
        context.save("test_int", 7)
        assertEquals(7,context.load("test_int", Int::class)?:0)
    }

    @Test
    fun testSaveLoadLong() {
        context.save("test_long", 77777777L)
        assertEquals(77777777L,context.load("test_long", Long::class)?:0L)
    }

    @Test
    fun testSaveLoadFloat() {
        context.save("test_float", 7.7f)
        assertEquals(7.7f,context.load("test_float", Float::class)?:0.0f)
    }

    @Test
    fun testSaveLoadString() {
        context.save("test_string", "test")
        assertEquals("test",context.load("test_string", String::class)?:"")
    }

    @Test
    fun testSaveLoadBooleanArray() {
        val expected = arrayOf(true, true, false)
        context.save("test_bool_array", expected)
        val found = context.load("test_bool_array", Array<Boolean>::class) ?: emptyArray()

        assertNotEquals(0, found.size)
        found.forEachIndexed { index, b ->
            assertEquals(expected[index], b)
        }
    }

    @Test
    fun testSaveLoadIntArray() {
        val expected = arrayOf(1, 2, 3)
        context.save("test_int_array", expected)
        val found = context.load("test_int_array", Array<Int>::class) ?: emptyArray()

        assertNotEquals(0, found.size)
        found.forEachIndexed { index, i ->
            assertEquals(expected[index], i)
        }
    }

    @Test
    fun testSaveLoadLongArray() {
        val expected = arrayOf(1L, 2L, 3L)
        context.save("test_long_array", expected)
        val found = context.load("test_long_array", Array<Long>::class) ?: emptyArray()

        assertNotEquals(0, found.size)
        found.forEachIndexed { index, l ->
            assertEquals(expected[index], l)
        }
    }

    @Test
    fun testSaveLoadFloatArray() {
        val expected = arrayOf(1.0f, 2.0f, 3.0f)
        context.save("test_float_array", expected)
        val found = context.load("test_float_array", Array<Float>::class) ?: emptyArray()

        assertNotEquals(0, found.size)
        found.forEachIndexed { index, f ->
            assertEquals(expected[index], f)
        }
    }

    @Test
    fun testSaveLoadStringArray() {
        val expected = arrayOf("ready", "set", "go")
        context.save("test_string_array", expected)
        val found = context.load("test_string_array", Array<String>::class) ?: emptyArray()

        assertNotEquals(0, found.size)
        found.forEachIndexed { index, s ->
            assertEquals(expected[index], s)
        }
    }

    @Test
    fun testSaveLoadObject() {
        val expected = TestObject(
            false,
            23,
            23L,
            23.0f,
            "Test",
            arrayOf(true, true, true),
            arrayOf(23, 24, 25),
            arrayOf(23L, 24L, 25L),
            arrayOf(23.0f, 24.0f, 25.0f),
            arrayOf("Test1", "Test2", "Test3")
        )
        context.save("test_object", expected)
        val found = context.load("test_object", TestObject::class) ?: TestObject()

        assertEquals(expected, found)
    }

    @Test
    fun testSaveLoadObjectArrayList() {
        val expected = ArrayList<TestObject>()
        expected.add(
            TestObject(
                false,
                23,
                23L,
                23.0f,
                "Test",
                arrayOf(true, true, true),
                arrayOf(23, 24, 25),
                arrayOf(23L, 24L, 25L),
                arrayOf(23.0f, 24.0f, 25.0f),
                arrayOf("Test1", "Test2", "Test3")
            )
        )

        expected.add(
            TestObject(
                false,
                33,
                33L,
                33.0f,
                "Test1",
                arrayOf(true, true, true),
                arrayOf(33, 34, 35),
                arrayOf(33L, 34L, 35L),
                arrayOf(33.0f, 34.0f, 35.0f),
                arrayOf("Test10", "Test20", "Test30")
            )
        )

        context.save("test_object_array", expected)
        val found = context.load("test_object_array", ArrayList::class)

        found?.toTypedArray()?.forEachIndexed { index, testObject ->
            assertEquals(expected[index], testObject)
        }
    }

    @Test
    fun testSaveLoadObjectArray() {
        val expected = arrayOf(
            TestObject(
                false,
                23,
                23L,
                23.0f,
                "Test",
                arrayOf(true, true, true),
                arrayOf(23, 24, 25),
                arrayOf(23L, 24L, 25L),
                arrayOf(23.0f, 24.0f, 25.0f),
                arrayOf("Test1", "Test2", "Test3")
            ),
            TestObject(
                false,
                33,
                33L,
                33.0f,
                "Test1",
                arrayOf(true, true, true),
                arrayOf(33, 34, 35),
                arrayOf(33L, 34L, 35L),
                arrayOf(33.0f, 34.0f, 35.0f),
                arrayOf("Test10", "Test20", "Test30")
            )
        )
        context.save("test_object_array", expected)
        val found = context.load("test_object_array", ArrayList::class)

        found?.toTypedArray()?.forEachIndexed { index, testObject ->
            assertEquals(expected[index], testObject)
        }
    }

    @Test
    fun testLoadNonExistentObject() {
        assertNull(context.load("nonexistent_key", Boolean::class))
        assertNull(context.load("nonexistent_key", Int::class))
        assertNull(context.load("nonexistent_key", Long::class))
        assertNull(context.load("nonexistent_key", Float::class))
        assertNull(context.load("nonexistent_key", String::class))
        assertNull(context.load("nonexistent_key", Array<Boolean>::class))
        assertNull(context.load("nonexistent_key", Array<Int>::class))
        assertNull(context.load("nonexistent_key", Array<Long>::class))
        assertNull(context.load("nonexistent_key", Array<Float>::class))
        assertNull(context.load("nonexistent_key", Array<String>::class))
        assertNull(context.load("nonexistent_key", Serializable::class))
        assertNull(context.load("nonexistent_key", TestObject::class))
        assertNull(context.load("nonexistent_key", Array<TestObject>::class))
        assertNull(context.load("nonexistent_key", ArrayList::class))
    }

    @Test(expected = Exception::class)
    fun testUnsupportedObjectSave() {
        context.save("exception_key", UnsupportedTestObject())
    }

    @Test(expected = Exception::class)
    fun testUnsupportedArraySave() {
        context.save("exception_key", arrayOf(UnsupportedTestObject()))
    }

    @Test(expected = Exception::class)
    fun testUnsupportedArrayListSave() {
        val list = ArrayList<UnsupportedTestObject>()
        list.add(UnsupportedTestObject())
        context.save("exception_key", list)
    }

    @Test
    fun testUnsupportedObjectSaveSafe() {
        context.safeSave("exception_key", UnsupportedTestObject())
    }

    @Test
    fun testUnsupportedArraySaveSafe() {
        context.safeSave("exception_key", arrayOf(UnsupportedTestObject()))
    }

    @Test
    fun testUnsupportedObjectListSaveSafe() {
        val list = ArrayList<UnsupportedTestObject>()
        list.add(UnsupportedTestObject())
        context.safeSave("exception_key", list)
    }
}