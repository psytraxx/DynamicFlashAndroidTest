package de.dynamicflash.adaptor;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.dynamicflash.databinding.FragmentGalleryItemBinding;
import de.dynamicflash.model.Page;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 10/11/13
 * Time: 11:08
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private List<Page> pages;

    public GalleryAdapter(List<Page> list) {
        pages = list;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FragmentGalleryItemBinding binding = FragmentGalleryItemBinding.inflate(inflater, parent, false);
        return new GalleryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Page page = pages.get(position);
        holder.bind(page);
    }

    public void addPages(List<Page> pages) {
        this.pages = pages;
        notifyItemRangeChanged(0, pages.size());
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    public Page getItem(int position) {
        return pages.get(position);
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        private final FragmentGalleryItemBinding binding;

        public GalleryViewHolder(@NonNull FragmentGalleryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(@NonNull Page page) {
            binding.titleID.setText(page.getTitle());
            if (page.getDescription() != null) {
                binding.textID.setText(Html.fromHtml(page.getDescription(), Html.FROM_HTML_MODE_COMPACT));
            }
        }
    }
}
