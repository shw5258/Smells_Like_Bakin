package com.example.song.smellslikebakin;

        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //이 view는 list_item 목록한줄을 의미하는데 return때 ListViewHolder생성자의
        //변수로 들어가면서 목록전체영역에 클릭리스너가 붙는다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }
    //ViewHolder만으로 리스너가 붙지 않고 View.listener와 연합해야한다.
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;


        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            //onClickListener를 붙여 클릭할수 있게 한다.
            itemView.setOnClickListener(this);
        }
        //개체번호를 가지고 순서,해당사진,해당이름을 결정할 수 있다.
        public void bindView(int position) {
            mIndex = position;
            mTextView.setText(Recipes.names[position]);
            mImageView.setImageResource(Recipes.resourceIds[position]);
        }
        //onClick event발생하면 이 메서드 실행..
        @Override
        public void onClick(View v) {
            mListener.onListRecipeSelected(mIndex);
        }
    }
}
