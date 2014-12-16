package myListIterator.skeleton;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<E>
{
	private Object[] a;
	private int size,modCount;

	public MyArrayList()
	{
		this(10);
	}

	public MyArrayList(int initialCapacity)
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		a = new Object[initialCapacity];
		size = 0;
	}

	public int size()
	{
		return size;
	}

	@SuppressWarnings("unchecked")
    public E get(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		return (E) a[index];
	}

	@SuppressWarnings("unchecked")
	public E set(int index, E element)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object old = a[index];
		a[index] = element;
		return (E) old;
	}

	public boolean contains(Object elem)
	{
		for (int i = 0; i < size; i++)
		{
			if (elem == null ? a[i] == null : elem.equals(a[i]))
				return true;
		}
		return false;
	}

	public void trimToSize()
	{
		if (size < a.length)
		{
			Object[] b = new Object[size];
			System.arraycopy(a, 0, b, 0, size);
			a = b;
		}
	}

	public void add(E elem)
	{
		add(size, elem);
		modCount++;
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (size < a.length)
			System.arraycopy(a, index, a, index + 1, size - index);
		else
		{
			Object[] b = new Object[a.length * 2 + 1];
			System.arraycopy(a, 0, b, 0, index);
			System.arraycopy(a, index, b, index + 1, size - index);
			a = b;
		}
		a[index] = element;
		size++;
		modCount++;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object old = a[index];
		System.arraycopy(a, index + 1, a, index, size - (index + 1));
		size--;
		a[size] = null;
		modCount++;
		return (E) old;
	}

	public boolean remove(Object elem)
	{
		modCount++;
		for (int i = 0; i < size; i++)
		{
			if (elem.equals(a[i])) // TODO: TAKE NULL INTO ACCOUNT
			{
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ListIterator<E> listIterator()
	{
	    
	}
	
	public ListIterator<E> listIterator(int index)
	{
	    
	}
	
	private class MyListIterator implements ListIterator<E>
    {
	   private boolean wasPrevious,wasNext;
	   private int index,modcount;
	   
		public MyListIterator()
        {
	      wasPrevious=false;
	      wasNext=false;
	      index=0;
	      modcount=0;
        }

        private void verifyModCount()
        {
         if (!(this.modcount==modCount)){
        	 throw new ConcurrentModificationException();
         }
        }

        public boolean hasNext()
        {
        return index<=size;
        }

        public boolean hasPrevious()
        {
        return index>0;
        }

        public int previousIndex()
        {
            return index-1;
        }

        public int nextIndex()
        {
         return index+1;
        }

        public E previous()
        {
        
        }

        public E next()
        {
            
        }

        public void add(E o)
        {
            
        }

        public void set(E o)
        {
            
        }

        public void remove()
        {
            
        }
    }
}
